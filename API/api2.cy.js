/// <reference types="Cypress" />

const dataJson=require('../../fixtures/api.json')
describe('Post block', ()=>{
//Creating USER with POST call

let token='cc1e83df135e5bae76b58f2e48555fbe9e008f8a36fcd9c43dbe5234613bc0c9'
let random=''
let mail=''
    it('post test',()=>{
        cy.log(dataJson.name)
        cy.log(dataJson.Status)
        var pattern='ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890'
        for(let j=0;j<3;j++){
            random+=pattern.charAt(Math.floor(Math.random()*pattern.length))   
        }
        mail='TestMail'+random+'@gmail.com'
        cy.request({

            method:'POST',
            url:'https://gorest.co.in/public/v1/users',
            headers:{
                'Authorization':'Bearer '+token
            },
            body:{
                    "name": dataJson.name,
                    "gender":dataJson.gender,
                    "email" : mail,
                    "status": dataJson.Status
            }
        }).then((res)=>{
            cy.log(JSON.stringify(res))
            expect(res.status).to.eq(201)
            expect(res.body.data.name).to.eq(dataJson.name)
            cy.log(res.body.data.email)
            expect(res.body.data).has.property('name',dataJson.name)
            expect(res.body.data).has.property('email',mail)
            expect(res.body.data).has.property('gender',dataJson.gender)
            expect(res.body.data).has.property('status',dataJson.Status)

        })
    })
})