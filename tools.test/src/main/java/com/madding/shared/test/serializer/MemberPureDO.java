package com.madding.shared.test.serializer;


/**
 * 类MemberPureDO.java的实现描述：TODO 类实现描述 
 * @author madding.lip Sep 2, 2013 2:14:31 PM
 */
public class MemberPureDO {
    
//    private static final long serialVersionUID = 8619195265435316504L;
    
    private Long   id;
    private String name;
    private String ext;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "id=" + id+";name=" + name;
    }

    /**
     * @param ext the ext to set
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return the ext
     */
    public String getExt() {
        return ext;
    }
}
