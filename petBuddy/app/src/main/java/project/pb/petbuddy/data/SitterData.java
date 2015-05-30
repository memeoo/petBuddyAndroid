package project.pb.petbuddy.data;

import android.graphics.drawable.Drawable;

/**
 * Created by meme on 15. 5. 27..
 */
public class SitterData {
    public String nickName;
    public String addRess;
    public float avgRate;
    public int reviewCnt;
    public String miniResume;
    public int hostingCnt;
    public int maxReHostingCnt;
    public int priceDay;
    public int priceHour;
    public Drawable profileImg;

    public SitterData(String nickName, String addRess, Drawable profileImg) {
        this.nickName = nickName;
        this.addRess = addRess;
        this.profileImg = profileImg;
    }

    public SitterData(String nick, String address, float avgrate, int reviewcnt, String minResum,
                      int hostCnt, int maxRehosting, int pDay, int pHour, Drawable dr){
        nickName = nick;
        addRess = address;
        avgRate = avgrate;
        reviewCnt = reviewcnt;
        miniResume = minResum;
        hostingCnt = hostCnt;
        maxReHostingCnt = maxRehosting;
        priceDay = pDay;
        priceHour = pHour;
        profileImg = dr;

    }
}
