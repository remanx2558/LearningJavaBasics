package LinkedIn.model.user;

import java.util.ArrayList;
import java.util.List;

public class PersonalDetail {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String location;
    private String summary;

    // Additional profile information (R1)
    private List<String> education;
    private List<String> experiences;
    private List<String> achievements;
    private List<String> skills;

    // Constructor
    public PersonalDetail(String fullName, String email, String phoneNumber, String location, String summary) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.summary = summary;
        this.education = new ArrayList<>();
        this.experiences = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    // Getters
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getLocation() { return location; }
    public String getSummary() { return summary; }
    public List<String> getEducation() { return education; }
    public List<String> getExperiences() { return experiences; }
    public List<String> getAchievements() { return achievements; }
    public List<String> getSkills() { return skills; }


    // Setters

    public void addEducation(String edu) {
        education.add(edu);
    }

    public void addExperience(String exp) {
        experiences.add(exp);
    }

    public void addAchievement(String achievement) {
        achievements.add(achievement);
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public void setLocation(String location) {
        this.location = location;
    }



    public void setSummary(String summary) {
        this.summary = summary;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "PersonalDetail{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", summary='" + summary + '\'' +
                ", education=" + education +
                ", experiences=" + experiences +
                ", achievements=" + achievements +
                ", skills=" + skills +
                '}';
    }
}
