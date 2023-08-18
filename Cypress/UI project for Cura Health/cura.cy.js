import login from "../PageObjects/CuraHealthLogin";
import Appointment from "../PageObjects/CuraHealthAppointment";
const { should } = require("chai");

describe('cura health',()=>{
    const ln=new login();
    const ap=new Appointment();
    beforeEach(() => {
        cy.visit("https://katalon-demo-cura.herokuapp.com/");
    });
    it('Invalid login',()=>{
        ln.verifyMakeAppointment();
        ln.clickMakeAppointment();
        ln.setUsername('John Doe1');
        ln.setPassword('ThisIsNotAPassword1');
        ln.clickLogin();
        ln.verifyInvalidLogin();
    });
    it('valid login',()=>{
        ln.verifyMakeAppointment();
        ln.clickMakeAppointment();
        ln.setUsername('John Doe');
        ln.setPassword('ThisIsNotAPassword');
        ln.clickLogin();
        ln.verifyValidLogin();    
    });
    it('Make appointment',()=>{
        ln.verifyMakeAppointment();
        ln.clickMakeAppointment();
        ln.setUsername('John Doe');
        ln.setPassword('ThisIsNotAPassword');
        ln.clickLogin();
        ln.verifyValidLogin(); 
        let facility='Hongkong CURA Healthcare Center';
        let date='06/08/2023'
        let comment='Booking has been done and appointment to be booked'
        ap.selectFacility(facility);
        ap.clickReadmission();
        ap.clickRadioButton();
        ap.setDate(date)
        ap.setComment(comment)
        ap.clickAppointment();
    });

});