import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        // return [{
        //     id: '1',
        //     name: 'Humayun',
        //     age: 23,
        //     address: 'Rampura',
        //     dob: '23/11/1996'
        // }, {
        //     id: '2',
        //     name: 'Joy',
        //     age: 24,
        //     address: 'Dhaka',
        //     dob: '12/10/1999'
        // }];
        return this.store.findAll('list');
    }
});
