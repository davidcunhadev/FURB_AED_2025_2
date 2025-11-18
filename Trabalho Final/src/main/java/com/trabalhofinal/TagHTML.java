package com.trabalhofinal;

public class TagHTML implements Comparable<TagHTML> {
    private String tag;
    private int qtd;

    public TagHTML(String tag) {
        setTag(tag);
        this.qtd = 1;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        if (tag == null) tag = "";
        tag = tag.replace("<", "").replace(">", "").trim();
        this.tag = tag;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public int compareTo(TagHTML tag2) {
        return this.tag.compareTo(tag2.getTag());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TagHTML other = (TagHTML) obj;
        return this.tag.equals(other.tag);
    }

    @Override
    public int hashCode() {
        return this.tag.hashCode();
    }
}
