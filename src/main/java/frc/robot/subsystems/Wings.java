package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wings extends SubsystemBase {
    private DoubleSolenoid leftWing;
    private DoubleSolenoid rightWing;
    private boolean wingsOut=false;
    private boolean leftWingOut=false;
    private boolean rightWingOut=false;

    public Wings(DoubleSolenoid LeftWing, DoubleSolenoid RightWing){
        wingsOut = false;
        leftWing = LeftWing;
        rightWing = RightWing;
    }
    public void LeftWingIn(){
        leftWing.set(DoubleSolenoid.Value.kForward);
        leftWingOut=false;
    }
    public void LeftWingOut(){
        leftWing.set(DoubleSolenoid.Value.kReverse);
        leftWingOut=true;
    }
    public void LeftWingSwitch(){
        if(leftWingOut){
            LeftWingIn();
        } else {
            LeftWingOut();
        }
    }

    public void RightWingIn(){
        rightWing.set(DoubleSolenoid.Value.kForward);
        rightWingOut=false;
    }
    public void RightWingOut(){
        rightWing.set(DoubleSolenoid.Value.kReverse);
        rightWingOut=true;
    }    
    public void RightWingSwitch(){
        if(rightWingOut){
            RightWingIn();
        } else {
            RightWingOut();
        }
    }

    public void WingsIn(){
        RightWingIn();
        LeftWingIn();
        wingsOut = false;
    }
    public void WingsOut(){
        LeftWingOut();
        RightWingOut();
        wingsOut = true;
    }
    public void WingSwitch(){
        if(wingsOut){
            WingsIn();
        } else {
            WingsOut();
        }
    }
}
