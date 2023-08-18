class login{

    verifyMakeAppointment(){
        cy.get('#btn-make-appointment').should('have.text','Make Appointment')
    }
    clickMakeAppointment(){
        cy.get('#btn-make-appointment').click()
    }
    setUsername(uname){
        cy.get('#txt-username').type(uname);
    }
    setPassword(pass){
        cy.get('#txt-password').type(pass)
    }
    clickLogin(){
        cy.get('#btn-login').click();
    }
    verifyInvalidLogin(){
        cy.get('.lead.text-danger').should('have.text','Login failed! Please ensure the username and password are valid.')
    }
    verifyValidLogin(){
      cy.get("label[for='combo_facility']").should('have.text','Facility')
      cy.get("body > section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > label:nth-child(1)").should('have.text','Healthcare Program')
    }
}
export default login;