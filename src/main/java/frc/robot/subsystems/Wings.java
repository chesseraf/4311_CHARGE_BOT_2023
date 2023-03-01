package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wings extends SubsystemBase {
    private DoubleSolenoid leftWing;
    private DoubleSolenoid rightWing;
    private boolean wingsOut=false;
    public Wings(DoubleSolenoid LeftWing, DoubleSolenoid RightWing){
        wingsOut = false;
        leftWing = LeftWing;
        rightWing = RightWing;
    }
    public void WingsIn(){
        leftWing.set(DoubleSolenoid.Value.kForward);
        rightWing.set(DoubleSolenoid.Value.kForward);
        wingsOut = false;
    }
    public void WingsOut(){
        leftWing.set(DoubleSolenoid.Value.kReverse);
        rightWing.set(DoubleSolenoid.Value.kReverse);
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
