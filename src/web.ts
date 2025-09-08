import { WebPlugin } from '@capacitor/core';
import type { RingtonePickerPlugin } from './definitions';

export class RingtonePickerWeb extends WebPlugin implements RingtonePickerPlugin {

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async pickRingtone(): Promise<{ uri: string; title: string }> {
    console.warn('RingtonePicker is not available on the web.');
    return { uri: '', title: '' };
  }
}
