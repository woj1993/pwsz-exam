/* global Monkey: true */
describe('Monkey', function ()
{
    'use strict';
    var monkey;
    beforeEach(function ()
    {
        monkey = new Monkey();
    });
    describe('when monkey gets hungry', function ()
    {
        beforeEach(function ()
        {
            monkey.makeHungry();
        });
        it('should ask for banana', function ()
        {
            expect(monkey.noise()).toEqual('banana');
        });
        describe('and when monkey gets banana', function ()
        {
            beforeEach(function ()
            {
                monkey.giveBanana();
            });
            it('should go crazy again', function ()
            {
                expect(monkey.noise()).toEqual('u-a-a');
            });
        });
    });
});
