import DS from 'ember-data';

const {Model} = DS;

export default Model.extend({
    name: DS.attr('string'),
    address: DS.attr('string'),
    dao: DS.attr('date')
});
