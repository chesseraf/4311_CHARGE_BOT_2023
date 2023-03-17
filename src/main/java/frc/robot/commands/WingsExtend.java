package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wings;

public class WingsExtend extends CommandBase{
    private Wings wing;
    
    public WingsExtend(Wings Wings){
        wing = Wings;
        addRequirements(wing);
    }
    @Override
    public void initialize() {
      //  wing.rightWing.set(DoubleSolenoid.Value.kReverse);
      //  rightWingOut=true;
      //  leftWing.set(DoubleSolenoid.Value.kForward);
      //  leftWingOut=false;
        wing.WingsOut();
    }
    @Override
    public void execute(){}

    @Override
    public boolean isFinished(){
        return true;
    }
}
