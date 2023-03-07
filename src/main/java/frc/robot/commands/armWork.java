package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class armWork extends CommandBase{
    private Arm arm;
    public armWork(Arm Arm){
        arm=Arm;
        addRequirements(arm);
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        if(RobotContainer.armInButton){
            System.out.println("moving arm inside");
            arm.ReachIn();
        } else if(RobotContainer.armOutButton){
            System.out.println("moving are out");
            arm.ReachOut();
        } else{
            arm.stop();
        }
    }
}
