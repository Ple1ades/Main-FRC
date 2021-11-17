package frc.robot.subsystems;

import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;

import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.RobotController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase{
    public WPI_VictorSPX m_leftFront = new WPI_VictorSPX(Constants.Drivetrain.leftFront);
    public WPI_TalonFX m_leftBack = new WPI_TalonFX(Constants.Drivetrain.leftBack);
    public SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftFront, m_leftBack);

    public WPI_VictorSPX m_rightFront = new WPI_VictorSPX(Constants.Drivetrain.rightFront);
    public WPI_TalonFX m_rightBack = new WPI_TalonFX(Constants.Drivetrain.rightBack);
    public SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightFront, m_rightBack);

    public DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    
    //private final SimpleMotorFeedforward m_feedforward = new SimpleMotorFeedforward(1, 3);
    
    private PIDController m_leftPIDController;
    private PIDController m_rightPIDController;
    
    private edu.wpi.first.wpilibj.Encoder m_leftEncoder;
    private edu.wpi.first.wpilibj.Encoder m_rightEncoder;
    
    public void DrivetrainSubsystem(){
        //clamp to between -1.0 and 1.0 for speed and rotation to prevent errors
      m_left.setInverted(true);
      m_right.setInverted(true);

      m_leftEncoder = new edu.wpi.first.wpilibj.Encoder(0,1);
      m_rightEncoder = new edu.wpi.first.wpilibj.Encoder(2,3);
      
      m_leftPIDController = new PIDController(Constants.Drivetrain.kP, Constants.Drivetrain.kI, Constants.Drivetrain.kD);
      m_rightPIDController = new PIDController(Constants.Drivetrain.kP, Constants.Drivetrain.kI, Constants.Drivetrain.kD);
      
      m_leftEncoder.setDistancePerPulse(2 * Math.PI * Constants.Drivetrain.kWheelRadius / Constants.Drivetrain.kEncoderResolution);
      m_rightEncoder.setDistancePerPulse(2 * Math.PI * Constants.Drivetrain.kWheelRadius / Constants.Drivetrain.kEncoderResolution);
    }
    
    
    // public void setSpeed(DifferentialDriveWheelSpeeds speeds){
    //   int leftSpeed = m_feedforward.calculate(Constants.Drivetrain.leftSpeed);
    //   int rightSpeed = m_feedforward.calculate(Constants.Drivetrain.rightSpeed);
    
    //   double leftPIDout = m_leftPIDController.calculate(m_leftEncoder.getRate(), Constants.Drivetrain.leftSpeed);
    //   double rightPIDout = m_rightPIDController.calculate(m_rightEncoder.getRate(), Constants.Drivetrain.rightSpeed);

    //   m_left.setVoltage(leftSpeed + leftPIDout);
    //   m_right.setVoltage(rightSpeed + rightPIDout);
    // }
    public void arcadeDrive(double speed, double rotation){
      m_drive.arcadeDrive(speed, rotation);
    }

    public void PIDAuto (double speed, double rotation, double dist) {
        m_drive.setSafetyEnabled(false);
        m_leftEncoder.reset();
        m_rightEncoder.reset();
        
        while (m_leftEncoder.getDistance() + m_rightEncoder.getDistance() != dist) {
          arcadeDrive(speed, rotation);
        }

    }
    
}