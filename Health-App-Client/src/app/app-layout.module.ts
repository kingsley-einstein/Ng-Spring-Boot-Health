import { NgModule } from '@angular/core';
import {
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule
} from '@angular/material';

@NgModule({
    imports: [
        MatInputModule,
        MatFormFieldModule,
        MatButtonModule,
        MatCardModule
    ],
    exports: [
        MatInputModule,
        MatFormFieldModule,
        MatButtonModule,
        MatCardModule
    ]
})
export class AppUIModule {}