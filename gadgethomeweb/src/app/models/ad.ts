import { User } from "./user";

export class Ad {
  constructor(
    public id: number,
    public device: string,
    public model: string,
    public brand: string,
    public description: string,
    public owner:User,
    public amount: number,
    public datePosted: Date
  ) {}
}
