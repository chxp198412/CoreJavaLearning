package com.andy.enumration;

enum Season{
    SPRING("spring", "warm"),
    SUMMER("summer", "hot"),
    AUTUMN("autumn", "cool"),
    WINTER("winter", "cold");

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    private String seasonName;
    private String seasonDesc;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public void setSeasonDesc(String seasonDesc) {
        this.seasonDesc = seasonDesc;
    }

}

public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SUMMER);
        System.out.println(Season.SUMMER.getSeasonName());
        System.out.println(Season.SUMMER.getSeasonDesc());

        for(Season season : Season.values()){
            System.out.println("Element in Season: " + season);
        }

        Season winter = Season.valueOf("WINTER");
        System.out.println(winter.getSeasonName());
        System.out.println(winter.getSeasonDesc());
    }
}
