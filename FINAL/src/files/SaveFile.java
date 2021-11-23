package files;

import user.UserProfile;

import java.io.Serializable;

public class SaveFile implements Serializable {
    boolean tutorialPassed;
    UserProfile userProfile;

    public SaveFile() {
        setTutorialPassed(false);
    }

    public void createUserProfile() {
        this.userProfile = new UserProfile();
    }

    public void setTutorialPassed(boolean tutorialPassed) {
        this.tutorialPassed = tutorialPassed;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public boolean getTutorialPassed() {
        return tutorialPassed;
    }

    public String getUserProfile() {
        if(userProfile == null) {
            return "= no profile yet";
        }
        return userProfile.toString();
    }

    @Override
    public String toString() {
        return  "\r\ntutorial_passed = " + getTutorialPassed() +
                "\r\nuser_profile " + getUserProfile();
    }
}
