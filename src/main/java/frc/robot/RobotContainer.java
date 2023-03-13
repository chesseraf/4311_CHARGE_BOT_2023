package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.WingFlap;
import frc.robot.commands.ArmHighThrow;
import frc.robot.commands.ArmLowPlace;
import frc.robot.commands.ArmMidPlace;
import frc.robot.commands.ArmReturnInside;
import frc.robot.commands.ArmWork;
import frc.robot.commands.AutoBalance;
import frc.robot.commands.AutoPlace;
import frc.robot.commands.BalanceDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.PutCone;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wings;

public class RobotContainer {
    public final static Joystick THRUSTMASTER = new Joystick(Constants.ports.thrusty);
    final DriveTrain DRIVE_TRAIN = new DriveTrain();

    final AnalogGyro GYRO = new AnalogGyro(0);

    private final DoubleSolenoid LEFT_WING = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.leftWingExtend, Constants.ports.leftWingRetract);
    private final DoubleSolenoid RIGHT_WING = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.rightWingExtend, Constants.ports.rightWingRetract);
    private final DoubleSolenoid armCone = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ports.armConeExtend, Constants.ports.armConeRetract);

    private final Wings WINGS = new Wings(LEFT_WING, RIGHT_WING);

    private final WPI_TalonFX ARM_TALON = new WPI_TalonFX(Constants.ports.arm);
    
    public final Arm ARM = new Arm(ARM_TALON,armCone);

    public static boolean wingsInside;
    public static boolean wingFlapButton;
    public static boolean rightWingFlapButton;
    public static boolean leftWingFlapButton;
    
    public static boolean lowShootButton;
    public static boolean midShootButton;
    public static boolean highShootButton;
    public static boolean armInButton;

    public static double joystickX;
    public static double joystickY;

   // private final  JoystickButton orangeButton = new JoystickButton(THRUSTMASTER, pistonTimer);
    private final Command ARM_COMMAND = new ArmWork(ARM);
    private final Command AUTO_BALANCE_COMMAND = new AutoBalance(DRIVE_TRAIN, GYRO);
    private final Command AUTO_PLACE_COMMAND = new AutoPlace(DRIVE_TRAIN, WINGS);
    private final Command BALANCE_DRIVE_COMMAND = new BalanceDrive(DRIVE_TRAIN,GYRO);
    private final Command TELEOP_COMMAND = new DriveWithJoystick(DRIVE_TRAIN, WINGS, GYRO);
    private final Command PUT_CONE_COMMAND = new PutCone(DRIVE_TRAIN, WINGS);
    private final Command WING_FLAPPER_COMMAND = new WingFlap(WINGS);
    private final Command SHOOT_LOW_GOAL_COMMAND = new ArmLowPlace(ARM);
    private final Command SHOOT_MID_GOAL_COMMAND = new ArmMidPlace(ARM);
    private final Command SHOOT_HIGH_GOAL_COMMAND = new ArmHighThrow(ARM);
    private final Command RETURN_ARM_COMMAND = new ArmReturnInside(ARM);

    //public Command 
    public Command GetReturnArmCommand(){
        return RETURN_ARM_COMMAND;
    }
    public Command GetLowGoalCommand(){
        return SHOOT_LOW_GOAL_COMMAND;
    }
    public Command GetMidGoalCommand(){
        return SHOOT_MID_GOAL_COMMAND;
    }
    public Command GetHighGoalCommand(){
        return SHOOT_HIGH_GOAL_COMMAND;
    }
    public Command GetArmCommand(){
        return ARM_COMMAND;
    }
    public Command GetAutoBalanceCommand(){
        return AUTO_BALANCE_COMMAND;
    }
    public Command GetAutoPlaceCommand(){
        return AUTO_PLACE_COMMAND;
    }
    public Command GetBalanceDriveCommand(){
        return BALANCE_DRIVE_COMMAND;
    }
    public Command GetTeleopCommand(){
        return TELEOP_COMMAND;
    }
    public Command GetPutConeCommand(){
        return PUT_CONE_COMMAND;
    }
    public Command GetWingFlapCommand(){
        return WING_FLAPPER_COMMAND;
    }

    public void SmartBoardUpdate(){
        SmartDashboard.putNumber("gyro angle ", GYRO.getAngle());
        SmartDashboard.putNumber("gyro rate ", GYRO.getRate());
        SmartDashboard.putBoolean("piston extended ", wingsInside);

        SmartDashboard.putNumber("arm position", ARM_TALON.getSelectedSensorPosition());
    }

    public void UpdateJoystick(){
        joystickX = THRUSTMASTER.getX();
        joystickY = THRUSTMASTER.getY();
        wingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.FLAP_WINGS);
        rightWingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.FLAP_RIGHT);
        leftWingFlapButton = THRUSTMASTER.getRawButton(Constants.buttons.FLAP_LEFT);
        armInButton = THRUSTMASTER.getRawButton(Constants.buttons.ARM_IN);
        lowShootButton = THRUSTMASTER.getRawButton(Constants.buttons.ARM_LOW_SHOOT);
        midShootButton = THRUSTMASTER.getRawButton(Constants.buttons.ARM_MID_SHOOT);
        highShootButton = THRUSTMASTER.getRawButton(Constants.buttons.ARM_HIGH_SHOOT);
    }
    public RobotContainer(){
        /* 
         Command ARM_COMMAND = new armWork(ARM);
        Command AUTO_BALANCE_COMMAND = new autoBalance(DRIVE_TRAIN, GYRO);
        Command AUTO_PLACE_COMMAND = new autoPlace(DRIVE_TRAIN, WINGS);
        Command BALANCE_DRIVE_COMMAND = new balanceDrive(DRIVE_TRAIN,GYRO);
         Command TELEOP_COMMAND = new driveWithJoystick(DRIVE_TRAIN, WINGS, GYRO);
        Command PUT_CONE_COMMAND = new putCone(DRIVE_TRAIN, WINGS);
        Command WING_FLAPPER_COMMAND = new WingFlap(WINGS);
        */
    }
}
