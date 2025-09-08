import { registerPlugin } from '@capacitor/core';

import type { RingtonePickerPlugin } from './definitions';

const RingtonePicker = registerPlugin<RingtonePickerPlugin>('RingtonePicker', {
  web: () => import('./web').then((m) => new m.RingtonePickerWeb()),
});

export * from './definitions';
export { RingtonePicker };
