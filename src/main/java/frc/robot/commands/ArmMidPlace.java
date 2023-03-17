package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wings;

public class ArmMidPlace extends  SequentialCommandGroup{
    public ArmMidPlace(Arm Arm, Wings wing){
        addRequirements(Arm);
        addRequirements(wing);
            addCommands(
            new WingsExtend(wing)
            .andThen(new ArmAngleSpeed(Arm, -50000, -0.4,-0.2,false, wing))//-50000,false
            .andThen(new ArmAngleSpeed(Arm, -110000, -0.9,-0.4,false, wing))
            .andThen(new ArmAngleSpeed(Arm, -170000, -0.9,-0.9,false, wing))
            .andThen(new ArmAngleSpeed(Arm, -170000, 0,0,false, wing))
            .andThen(new WaitCommand(0.3))
            .andThen(new ArmReturnInside(Arm, wing))
            //.andThen(new WaitCommand(3))
            //.andThen(new WingsRetract(wing))
            );
    }
}
