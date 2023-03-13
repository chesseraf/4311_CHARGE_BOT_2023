package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

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
     //   if(!Arm.armExecutingCommand){

            if(RobotContainer.armInButton){
                System.out.println("moving arm inside");
                //arm.ReachIn();
                CommandScheduler.getInstance().schedule(new ArmReturnInside(arm));
            } else if(RobotContainer.armOutButton){
                System.out.println("moving are out");
                arm.GoLow();
            } else {
                //arm.stop();
            }
        //}
        
        // buttons: tighten, untighten, goInside, 
    }
}
