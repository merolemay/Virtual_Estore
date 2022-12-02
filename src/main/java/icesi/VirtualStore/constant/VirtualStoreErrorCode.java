package icesi.VirtualStore.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VirtualStoreErrorCode {

    CODE_I_01("Item Type not found"),
    CODE_O_01("Order not found"),
    CODE_U_01("User not found"),
    CODE_01("An argument is invalid"),
    CODE_L_01("Login failed"),
    CODE_L_02("The password is incorrect"),
    CODE_L_03("Unauthorized"),
    CODE_L_04("Role"),
    CODE_I_02("Not enough items available"),
    CODE_U_02("Either email or phone number must be present"),
    CODE_U_03("The email invalid"),
    CODE_U_04("The phone number invalid");

    private final String message;
}
