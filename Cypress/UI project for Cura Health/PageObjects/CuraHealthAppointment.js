class Appointment{

    selectFacility(facility){
        cy.get('#combo_facility').select(facility)
    }
    clickReadmission(){
        cy.get('#chk_hospotal_readmission').click();
        
    }
    clickRadioButton(){
        cy.get('#radio_program_medicaid').click();
    }
    setDate(date){
        cy.get('#txt_visit_date').type(date);      
    }
    setComment(comment){
        cy.get('#txt_comment').click({force:true})
        cy.get('#txt_comment').type(comment)
    }
    clickAppointment(){
        cy.get('#btn-book-appointment').click();
    }
    verifyAppointment(facility1,date1,comment1){
        cy.get('h2').should('have.text','Appointment Confirmation');
        cy.get('#facility').should('have.text',facility1)
        cy.get('#visit_date').should('have.text',date1)
        cy.get('#comment').should('have.text',comment1)
    }
}
export default Appointment;