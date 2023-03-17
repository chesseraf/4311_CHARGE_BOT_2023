package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmReturnInside extends SequentialCommandGroup{

    public ArmReturnInside(Arm Arm, Wings wing){
        //addRequirements(wing);
        //addRequirements(Arm);

        addCommands(
        
        new WingsExtend(wing)
        .andThen(new ArmAngleSpeed(Arm, -1000, 0.31,0.3,true, wing))

        //.andThen(RobotContainer.WINGS.WingSwitch)
        );
        //addCommands(new ArmMotorTimeMove(Arm,3,0.25));
    }
}
