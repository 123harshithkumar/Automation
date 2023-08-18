/// <reference types="Cypress"/>
describe ('apiBlock', ()=> {

let token='cc1e83df135e5bae76b58f2e48555fbe9e008f8a36fcd9c43dbe5234613bc0c9'

    it.only('apitTest',()=> {
        cy.request({
            method : 'GET',
           // url : 'https://gorest.co.in/public/v2/users',
           url : 'https://gorest.co.in/public-api/users',
            methods : {
                'Authorization' : 'Bearer '+token
            }
        }).then((res)=>{

            cy.log(JSON.stringify(res))
      
         //   cy.log(res.body.id)
            expect(res.status).to.eq(200)
            expect(res.body.meta.pagination.total).to.eq(2875)
            
        })
    })
    it('apitTest',()=> {
        cy.request({
            method : 'GET',
           url : 'https://gorest.co.in/public/v2/users',
           //url : 'https://gorest.co.in/public-api/users',
            methods : {
                'Authorization' : 'Bearer '+token
            }
        }).then((res)=>{

            cy.log(JSON.stringify(res))
      
            for(let i=0;i<=9;i++){
                cy.log(res.body[i].id)
            }
            
            expect(res.status).to.eq(200)
            //expect(res.body.id).to.eq(4475906)
            expect(res.body[0].id).to.eq(4475906)
            
        })
    })
})