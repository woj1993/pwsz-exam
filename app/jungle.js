function jungle()
{
    return 'wofbrrrriiiitrututu';
}

function Monkey()
{

}
Monkey.prototype.makeHungry = function ()
{
    this.hungry = true;
}
Monkey.prototype.giveBanana = function ()
{
    this.hungry = false;
}
Monkey.prototype.noise = function ()
{
    var noise = 'u-a-a';
    if (this.hungry)
        noise = 'banana';
        return noise;
}
