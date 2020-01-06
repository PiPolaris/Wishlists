export interface Item {
    id: number;
    name: string;
    description: string;
    image: string;
    cloth: string;
    color: string;
    location: string;
    price: number;
    likes: number;
    coments: number;
    content: Item;
}