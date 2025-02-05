package LinkedIn;

import java.io.ByteArrayInputStream;

public class Profile {
    Byte[] profilePicture;
    Byte[]coverPhotot;
    String headline;
    String about;
    String gender;
    Education[] educations;
    Experience[] experiences;
    Skill[] skills;
    Achievements[] achievements;
    Recommendation[] recommendations;
    Analytics analytics;




    boolean addSkill(Skill skill){return false;}
    boolean removeSkill(String skillId){return false;}


    boolean addExperience(Experience experience){return false;}
    boolean removeExperience(String experienceId){return false;}

    boolean addEducation(Education education){return false;}
    boolean removeEducation(String educationId){return false;}


    boolean addAchievement(Achievements achievements){return false;}


}
