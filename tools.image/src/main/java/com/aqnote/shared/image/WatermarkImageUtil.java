/*
 * Copyright (C) 2013-2016 Peng Li<aqnote@qq.com>.
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */
package com.aqnote.shared.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.aqnote.shared.image.BMPImageUtil;
import com.aqnote.shared.image.ImageUtil;

public class WatermarkImageUtil {

  private static final int DOWN_RIGHT = 0;
  private static final int DOWN_LEFT = 1;
  private static final int UP_RIGHT = 2;
  private static final int UP_LEFT = 3;
  private static final int MIDDLE = 4;
  private static final int UP_LEFT_TO_DOWN_RIGHT = 5;
  private static final int UP_RIGHT_TO_DOWN_LEFT = 6;

  // 实现加水印方法
  public static BufferedImage watermark(
      String filepath, Font font, Color color, int toward, String mark, float alpha, float scale) {
    return watermark(new File(filepath), font, color, toward, mark, alpha, scale);
  }

  /**
   * 获取绘画该字符串所需的高度和宽度
   *
   * @param str String 所要测量的字符串
   * @param g2d Graphics2D
   * @return Point
   */
  private static Point getStringWidthAndHeight(String str, Graphics2D g2d) {
    FontMetrics fontMetrics = g2d.getFontMetrics();
    int stringWidth = fontMetrics.stringWidth(str);
    int stringAscent = fontMetrics.getAscent();
    return new Point(stringWidth, stringAscent);
  }

  /**
   * 添加水印
   *
   * @param alpha 水印的透明度
   * @param font 水印的字体
   * @param mark 水印的内容
   * @param g2d Graphics2D
   * @param degree 旋转的角度
   * @param x 水印起始的x坐标
   * @param y 水印起始的y坐标
   */
  private static void printWatemark(float alpha, String mark, Graphics2D g2d, int x, int y) {
    // 在图形和图像中实现混合和透明效果
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

    g2d.drawString(mark, x, y);
  }

  /**
   * 算法选择
   *
   * @return RenderingHints的一个对象
   */
  private static RenderingHints getMyRenderingHints() {
    RenderingHints rh =
        new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, // 抗锯齿提示键。
            RenderingHints.VALUE_ANTIALIAS_ON); // 抗锯齿提示值——使用抗锯齿模式完成呈现。
    rh.put(
        RenderingHints.KEY_TEXT_ANTIALIASING, // 文本抗锯齿提示键。
        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB); // 要求针对 LCD 显示器优化文本显示
    rh.put(
        RenderingHints.KEY_ALPHA_INTERPOLATION, // Alpha 插值提示值
        RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); // Alpha 插值提示值——选择偏重于精确度和视觉质量的 alpha 混合算法
    rh.put(
        RenderingHints.KEY_RENDERING, // 呈现提示键。
        RenderingHints.VALUE_RENDER_QUALITY); // 呈现提示值——选择偏重输出质量的呈现算法
    rh.put(
        RenderingHints.KEY_STROKE_CONTROL, // 笔划规范化控制提示键。
        RenderingHints.VALUE_STROKE_NORMALIZE); // 几何形状应当规范化，以提高均匀性或直线间隔和整体美观。
    rh.put(
        RenderingHints.KEY_COLOR_RENDERING, // 颜色呈现提示键。
        RenderingHints.VALUE_COLOR_RENDER_QUALITY); // 用最高的精确度和视觉质量执行颜色转换计算。
    return rh;
  }

  private static Point calculate(Point p, int toward, double imgWidth, double imgHeight) {
    int x = 0, y = 0;
    if (toward == UP_LEFT_TO_DOWN_RIGHT) {
      double hypotenuse = Math.sqrt(Math.pow(imgWidth, 2) + Math.pow(imgHeight, 2));
      double tempX = (p.x / 2) * imgWidth / hypotenuse;
      double tempY = (p.x / 2) * imgHeight / hypotenuse;
      x = (int) (imgWidth / 2 - tempX);
      y = (int) (imgHeight / 2 - tempY);
    } else if (toward == UP_RIGHT_TO_DOWN_LEFT) {
      double hypotenuse = Math.sqrt(Math.pow(imgWidth, 2) + Math.pow(imgHeight, 2));
      double tempX = (p.x / 2) * imgWidth / hypotenuse;
      double tempY = (p.x / 2) * imgHeight / hypotenuse;
      x = (int) (imgWidth / 2 - tempX);
      y = (int) (imgHeight / 2 + tempY);
    } else if (toward == DOWN_RIGHT) {
      x = (int) imgWidth - p.x;
      y = (int) imgHeight - p.y;
    } else if (toward == DOWN_LEFT) {
      x = 5;
      y = (int) imgHeight - p.y;
    } else if (toward == UP_RIGHT) {
      x = (int) imgWidth - p.x - 3;
      y = p.y;
    } else if (toward == UP_LEFT) {
      x = 5;
      y = p.y;
    } else if (toward == MIDDLE) {
      x = (int) imgWidth / 2 - p.x / 2;
      y = (int) imgHeight / 2;
    }
    return new Point(x, y);
  }

  public static BufferedImage watermark(
      File file, Font font, Color color, int toward, String mark, float alpha, float scale) {
    BufferedImage buffImg = ImageUtil.getFileImageAndScale(file, scale);
    // 创建Graphics2D对象，用在BufferedImage对象上绘图
    Graphics2D g2d = buffImg.createGraphics();
    g2d.setRenderingHints(getMyRenderingHints());
    g2d.setFont(font);
    g2d.setColor(color);

    double imgWidth = buffImg.getWidth();
    double imgHeight = buffImg.getHeight();

    // 绘画字符串所需的宽和高
    Point p = getStringWidthAndHeight(mark, g2d);

    // 计算绘画字符串的起点
    Point p1 = calculate(p, toward, imgWidth, imgHeight);

    // 设置水印旋转
    // 平移到指定位置，旋转指定弧度
    if (toward == UP_LEFT_TO_DOWN_RIGHT) {
      g2d.rotate(
          Math.atan(imgHeight / imgWidth), // Math.toRadians(135)
          p1.x,
          p1.y);
    } else if (toward == UP_RIGHT_TO_DOWN_LEFT) {
      g2d.rotate(
          -Math.atan(imgHeight / imgWidth), // Math.toRadians(135)
          p1.x,
          p1.y);
    }
    printWatemark(alpha, mark, g2d, p1.x, p1.y);
    g2d.dispose(); // 释放图形上下文使用的系统资源
    return buffImg;
  }
}
