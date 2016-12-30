package com.demo.recyclerviewwithcardview;

public class DataObject {
    private String HeadingText;
    private String DescriptionText;

    DataObject (String text1, String text2){
        HeadingText = text1;
        DescriptionText = text2;
    }

    public String getHeading() {
        return HeadingText;
    }

    public void setHeading(String Heading) {
        this.HeadingText = Heading;
    }

    public String getDescription() {
        return DescriptionText;
    }

    public void setDescription(String Description) {
        this.DescriptionText = Description;
    }
}
