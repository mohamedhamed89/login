package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator(value="passValidator")
public class passValidator implements Validator {

	public passValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String password = arg2.toString();
		UIInput UConfirmedPassword = (UIInput)arg1.getAttributes().get("confirmPassword");
		String confirmedPassword = UConfirmedPassword.getSubmittedValue().toString();
		if(password.length()<4 || confirmedPassword.length()<4){
			
			throw new ValidatorException(new FacesMessage("Password must be more than 4 Character"));
		}
		if( ! password.equals(confirmedPassword)){
			throw new ValidatorException(new FacesMessage("Password not maching"));
			
		}
		
	}

}