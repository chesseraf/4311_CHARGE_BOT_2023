package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class putCone  extends CommandBase{
    private  DriveTrain driveTrain;


    public putCone(DriveTrain DriveTrain, Wings wing){

        driveTrain = DriveTrain;
        addRequirements(driveTrain);
        //slightly back up before placing cone
     //   andThen flip the arm with the cone
     //   andThen release the cone
     //   andThen return the arm into the robot
     //   finish
        
    }

    
}
