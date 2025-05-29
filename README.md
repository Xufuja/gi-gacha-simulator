# GI Gacha Simulator

## Overview

Based on pseudocode provided by: https://www.hoyolab.com/article/497840

```
_rate5 = .006   # 0.6%
_rate4 = .051   # 5.1%
_pity5 = 73     # 5* pity starts after 73 attempts
_pity4 = 8      # 4* pity starts after 8 attempts

# counter5 and counter4 are the (persistent) user state for this banner (initialize to 1)

x = random()    # between 0.0 and 1.0
prob5 = _rate5 + max(0, (counter5-_pity5) * 10 * _rate5)
prob4 = _rate4 + max(0, (counter4-_pity4) * 10 * _rate4)

if (x < prob5) {
	drop(5star)
	counter5 = 1;
	counter4 += 1
} else if (x < prob4 + prob5) {
	drop(4star)
	counter5 += 1;
	counter4 = 1;
} else {
	drop(3star)
	counter5 += 1;
	counter4 += 1;

}
```
