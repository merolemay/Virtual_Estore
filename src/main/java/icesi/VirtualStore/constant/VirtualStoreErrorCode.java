package icesi.VirtualStore.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VirtualStoreErrorCode {

    CODE_I_01("Item Type not found"),
    CODE_O_01("Order not found"),
    CODE_U_01("User not found"),
    CODE_02("The parent must exist in the database"),
    CODE_03("The mother must be a female"),
    CODE_04("The father must be a male"),
    CODE_05("The name must be unique"),
    CODE_06("An argument is invalid"),

    CODE_L_01("Login failed"),
    CODE_L_02("The password is incorrect");

    private final String message;
}
