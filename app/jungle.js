/* exported jungle */
function jungle()
{
    'use strict';
    return 'wofbrrrriiiitrututu';
}

function Monkey()
{
    'use strict';

}
Monkey.prototype.makeHungry = function ()
{
    'use strict';
    this.hungry = true;
}
Monkey.prototype.giveBanana = function ()
{
    'use strict';
    this.hungry = false;
}
Monkey.prototype.noise = function ()
{
    'use strict';
    var noise = 'u-a-a';
    if (this.hungry)
        noise = 'banana';
        return noise;
}
