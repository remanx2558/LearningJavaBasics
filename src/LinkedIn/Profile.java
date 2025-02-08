package LinkedIn;


import java.util.List;

public class Profile {

    private byte[] profilePicture;
    private String title;
    private String about;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;
    private List<Achievement> achievements;
    private Analytics analytics;

    public void addExperience(Experience exp) { }
    public void addAchievement(Achievement ach) { }


    Byte[]coverPhotot;
    String headline;
    String gender;

    Recommendation[] recommendations;




    boolean addSkill(Skill skill){return false;}
    boolean removeSkill(String skillId){return false;}


    boolean removeExperience(String experienceId){return false;}

    boolean addEducation(Education education){return false;}
    boolean removeEducation(String educationId){return false;}


}
