package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmWork extends CommandBase{
    private Arm arm;
    public ArmWork(Arm Arm){
        arm=Arm;
        //addRequirements(arm);
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        if(Wings.rightWingOut && Wings.leftWingOut){
            if(RobotContainer.armInButton){
                arm.GoInside();
            } else if(RobotContainer.lowShootButton){
                arm.GoLow();
            } else if(RobotContainer.midShootButton){
                arm.GoMid();
            } else if(RobotContainer.highShootButton){
                arm.GoHigh();
            } 
            /*else if(RobotContainer.armStopButton){
                arm.stop();
            }      
            */     
        }
    }
}
