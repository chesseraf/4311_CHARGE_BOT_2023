package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Wings;

public class WingFlap extends CommandBase{
    private Wings wings;
    private boolean flappingBoth;
    private boolean flappingRight;
    private boolean flappingLeft;
    
    
    public WingFlap(Wings Wings){
        wings = Wings;
        addRequirements(wings);
    }
    @Override
    public void initialize() {
        flappingLeft = false;
        flappingRight = false;
        flappingBoth = false;
    }
    @Override
    public void execute() {
        /* flap both */
        if(RobotContainer.wingFlapButton){
            if(!flappingBoth){
                wings.WingSwitch();
            }
            flappingBoth=true;
        } else {
            flappingBoth=false;
        } 
       /* */
       
        //flap left
        if(RobotContainer.leftWingFlapButton){
            if(!flappingLeft){
                wings.LeftWingSwitch();
            }
            flappingLeft=true;
        } else {
            flappingLeft=false;
        }
        
        //flap right
        if(RobotContainer.rightWingFlapButton){
            if(!flappingRight){
                wings.RightWingSwitch();
            }
            flappingRight=true;
        } else {
            flappingRight=false;
        }
    }
    @Override 
    public boolean isFinished(){
        return false;
    }    
}
