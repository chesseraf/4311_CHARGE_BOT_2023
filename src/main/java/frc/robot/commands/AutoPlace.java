package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class AutoPlace extends SequentialCommandGroup{
  private Arm arm;
    public AutoPlace(DriveTrain driveTrain, Wings wings,Arm ARm) {
      arm = ARm;
      addRequirements(driveTrain);
      addRequirements(wings);
      addRequirements(arm);

       addCommands(
          new WingsExtend(wings)
          //.andThen(new DriveForTime(driveTrain,2, -0.4, 0))
          .andThen(new WaitCommand(1.2))
          .andThen(new ArmHighThrow(arm,wings,true))
          .andThen(new WaitCommand(0.2))
          .andThen(new ArmReturnInside(arm, wings))
          .andThen(new WaitCommand(0.4))
          .andThen(new WingsRetract(wings))
          .andThen(new DriveForTime(driveTrain,3.25, -0.5, 0))
       );
      }     
}
