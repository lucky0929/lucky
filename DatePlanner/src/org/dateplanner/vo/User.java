package org.dateplanner.vo;

import java.sql.Date;

public class User {

      private Integer no;
       private String name;
       private String key;
       private String nickname;
       private String sex;
       private String profile;
       private Integer regionNo;
       private String introduction;
       private Date regdate;
       private Character platform;
       
      public Character getPlatform() { return platform; }
      public void setPlatform(Character platform) { this.platform = platform; }
      public Integer getNo() { return no; }
      public void setNo(Integer no) { this.no = no; }
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
      public String getKey() { return key; }
      public void setKey(String key) { this.key = key; }
      public String getNickname() { return nickname; }
      public void setNickname(String nickname) { this.nickname = nickname;}
      public String getSex() { return sex; }
      public void setSex(String sex) { this.sex = sex; }
      public String getProfile() { return profile; }
      public void setProfile(String profile) { this.profile = profile; }
      public Integer getRegionNo() { return regionNo; }
      public void setRegionNo(Integer regionNo) { this.regionNo = regionNo; }
      public String getIntroduction() { return introduction; }
      public void setIntroduction(String introduction) { this.introduction = introduction; }
      public Date getRegdate() { return regdate; }
      public void setRegdate(Date regdate) { this.regdate = regdate; }
      @Override
      public String toString() {
         return "User [no=" + no + ", name=" + name + ", key=" + key + ", nickname=" + nickname + ", sex=" + sex
               + ", profile=" + profile + ", regionNo=" + regionNo + ", introduction=" + introduction
               + ", regdate=" + regdate + ", platform=" + platform + "]";
      }
} //User