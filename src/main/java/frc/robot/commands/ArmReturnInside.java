package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmReturnInside extends SequentialCommandGroup{
    public ArmReturnInside(Arm Arm){
        addCommands(new ArmAngleMove(Arm, 0, 0.5));
        //addCommands(new ArmMotorTimeMove(Arm,3,0.25));
    }
}
