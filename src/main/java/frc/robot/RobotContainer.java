package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.WingFlap;
import frc.robot.commands.autoPlace;
import frc.robot.commands.driveWithJoystick;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;
import frc.robot.Constants;


public class RobotContainer {
    public final static Joystick THRUSTMASTER = new Joystick(Constants.ports.thrusty);
    final DriveTrain DRIVE_TRAIN = new DriveTrain();

    // timers
    public static int timer;
    public static int pistonTimer;
    public static int [] timers;
/* 
    //auto chooser
    private static final String balanceAuto = "Default";
    private static final String placeAuto = "My Auto";
    private String autoChosen;
    private final SendableChooser<String> autoChoice = new SendableChooser<>();
*/
    // gyro
    private final AnalogGyro gyro = new AnalogGyro(0);

   
   
   // public final Compressor comp = new Compressor( Constants.ports.commpressor , PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid leftWing = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.leftWingExtend, Constants.ports.leftWingRetract);
    private final DoubleSolenoid rightWing = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.rightWingExtend, Constants.ports.rightWingRetract);
   
    private final DoubleSolenoid armCone = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.armConeExtend, Constants.ports.armConeRetract);

    private final Wings WINGS = new Wings(leftWing, rightWing);
    public final Command flaperCommand = new WingFlap(WINGS);

    public static boolean wingsInside;
    public static boolean wingFlapButton;

    public static double joystickX;
    public static double joystickY;

   // private final  JoystickButton orangeButton = new JoystickButton(THRUSTMASTER, pistonTimer);
    
    private final CommandBase AUTOPLACE = 
        new autoPlace(DRIVE_TRAIN, WINGS);

    private final CommandBase TELEOPCOMMAND = 
      new driveWithJoystick(DRIVE_TRAIN, WINGS, gyro);

    public Command getAutoCommand(){
        return AUTOPLACE;
    }
    public Command getTeleopCommand(){
        return TELEOPCOMMAND;
    }
    public void enableComp(){
        System.out.println("compressor enabling");
     //   comp.enableDigital();
    }
    public void updateJoystick(){
        joystickX = THRUSTMASTER.getX();
        joystickY = THRUSTMASTER.getY();
        wingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.flapWings);
        //add buttons too
      }
    public RobotContainer(){
       
    }
}
