/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class AbstractFactory {
    // Button.java
public interface Button {
    void render();
}

// PublicHospitalButton.java
public class PublicHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Public Hospital Button");
    }
}

// PrivateHospitalButton.java
public class PrivateHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Private Hospital Button");
    }
}

// UIFactory.java
public interface UIFactory {
    Button createButton();
}

// PublicHospitalUIFactory.java
public class PublicHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PublicHospitalButton();
    }
}

// PrivateHospitalUIFactory.java
public class PrivateHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PrivateHospitalButton();
    }
}
}
