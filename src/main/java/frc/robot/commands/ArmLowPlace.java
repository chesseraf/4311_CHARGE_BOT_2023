package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ArmLowPlace extends SequentialCommandGroup{
    public ArmLowPlace(Arm Arm){
        /*addCommands(new ArmMotorTimeMove(Arm, 1.5, -0.2)
        .andThen(new ArmMotorTimeMove(Arm, 1.5, -0.15))
        );*/
       // addCommands(new ArmAngleMove(Arm, -130000, -1) high shot pottentially, ends half way
        //.andThen(new ArmAngleMove(Arm, -240000, -0.8))
        //addCommands(new ArmAngleMove(Arm, -180000, -1)//mid goal
        //.andThen(new ArmAngleMove(Arm, -240000, -0.8))
        addCommands(new ArmAngleMove(Arm, -50000, -0.7)
        .andThen(new ArmAngleMove(Arm, -180000, -1))
        );
    }
}
