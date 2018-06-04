package model;

public class EventData {
    private String name;
    private String header;
    private String footer;

    public EventData withName(String name) {
        this.name = name;
        return this;
    }

    public EventData withHeader(String header) {
        this.header = header;
        return this;
    }

    public EventData withFooter(String footer) {
        this.footer = footer;
        return this;
    }


    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
