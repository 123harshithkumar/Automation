const { should } = require("chai");

describe('cura health',()=>{
    beforeEach(() => {
        cy.visit("https://katalon-demo-cura.herokuapp.com/");
    });
    it('login',()=>{
        //cy.visit("https://katalon-demo-cura.herokuapp.com/");
        // cy.log("Logged in to Cura health care");
        // cy.wait(10000)
        cy.get('#btn-make-appointment').should('have.text','Make Appointment');
       
        
    });
    it('Make appointment',()=>{
        cy.get('#btn-make-appointment').should('have.text','Make Appointment');
        cy.get('#btn-make-appointment').click();
        cy.get('#txt-username').type('John Doe');
        cy.get('#txt-password').type('ThisIsNotAPassword')
        cy.get('#btn-login').click();
        let facility='Hongkong CURA Healthcare Center';
        cy.get('#combo_facility').select(facility)
        cy.get('#chk_hospotal_readmission').click();
        cy.get('#radio_program_medicaid').click();
        let date='06/08/2023'
        cy.get('#txt_visit_date').type(date);
        cy.get('#txt_comment').click({force:true})
        let comment='Booking has been done and appointment to be booked'
        cy.get('#txt_comment').type(comment)
        cy.get('#btn-book-appointment').click();
        cy.get('h2').should('have.text','Appointment Confirmation');
        cy.get('#facility').should('have.text',facility)
        cy.get('#visit_date').should('have.text',date)
        cy.get('#comment').should('have.text',comment)


    });

});