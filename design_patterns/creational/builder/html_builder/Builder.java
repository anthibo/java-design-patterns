package design_patterns.creational.builder.html_builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {

    String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(indentSize * (indent + 1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements)
            sb.append(e.toStringImpl(indent + 1));

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }

}

class HtmlBuilder
{
   
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }
    public void addChild(String childname, String childText) {
        HtmlElement e = new HtmlElement(childname, childText);
        root.elements.add(e);
    }

    public void clear() {
        root  = new HtmlElement();
        root.name = rootName;
    }
    @Override
    public String toString() {
        return root.toString();
    }

    
}

public class Builder {
    public static void main(String[] args) {
       HtmlBuilder builder = new HtmlBuilder("ul");
       builder.addChild("li", "hello");
       builder.addChild("li", "world");
       System.out.println(builder);

    }
}
