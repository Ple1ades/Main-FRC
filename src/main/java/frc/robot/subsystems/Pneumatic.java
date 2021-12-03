package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class Pneumatic extends SubsystemBase{

    // Compressor m_comp = new Compressor(0);
    // c.setClosedLoopControl(true);
    // c.setClosedLoopControl(false);

    // boolean m_enabled = m_comp.enabled();
    // boolean m_pressureSwitch = m_comp.getPressureSwitchValue();
    // double m_current = m_comp.getCompressorCurrent();

    public DoubleSolenoid m_solenoid = new DoubleSolenoid(Constants.Pneumatics.solenoidIDA, Constants.Pneumatics.solenoidIDB, Constants.Pneumatics.solenoidIDC);
    // public DoubleSolenoid m_dDoubleSolenoid = new DoubleSolenoid;
    public Pneumatic(){
           
    }
    public void move(DoubleSolenoid.Value direction){
        m_solenoid.set(direction);
    }
}
