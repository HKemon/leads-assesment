import Route from '@ember/routing/route';

export default Route.extend({
  model() {
    return [{
      id: '1',
      name: 'Humayun',
      address: 'Rampura',
      dob: '23/11/1996'
    }, {
      id: '2',
      name: 'Joy',
      address: 'Dhaka',
      dob: '12/10/1999'
    }];
  }
});
