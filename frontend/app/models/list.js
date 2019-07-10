import DS from 'ember-data';
const { Model } = DS;

export default Model.extend({
    name: DS.attr('string'),
    age: DS.attr('number'),
    address: DS.attr('string'),
    dateOfBirth: DS.attr('string')
});
